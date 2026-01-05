package lukeisbrecht.notrampling.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lukeisbrecht.notrampling.config.TrampleProtection;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_DIR = FabricLoader.getInstance().getConfigDir().toFile();

    public static class SaveData {
        public TrampleProtection protection = TrampleProtection.FULL;
    }

    private static SaveData data = new SaveData();

    public static void load() {
        File file = new File(CONFIG_DIR, "croptrampling_data.json");

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                data = GSON.fromJson(reader, SaveData.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void save() {
        File file = new File(CONFIG_DIR, "croptrampling_data.json");

        try (FileWriter writer = new FileWriter(file)) {
            GSON.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SaveData getData() {
        return data;
    }
}