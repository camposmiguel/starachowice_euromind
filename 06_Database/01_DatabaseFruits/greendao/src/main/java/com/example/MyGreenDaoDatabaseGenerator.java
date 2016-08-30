package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGreenDaoDatabaseGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.miguelcr.fruits");

        databaseFruits(schema);

        new DaoGenerator().generateAll(schema, "../01_DatabaseFruits/app/src/main/java");
    }

    private static void databaseFruits(Schema schema) {
        Entity fruitTable = schema.addEntity("Fruits");
        fruitTable.addIdProperty().autoincrement().primaryKey();
        fruitTable.addStringProperty("name");
        fruitTable.addIntProperty("icon");
        fruitTable.addIntProperty("quantity");
    }


}
