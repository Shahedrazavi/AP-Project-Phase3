package db;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.Config;
import model.ID;
import model.User;
import util.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class UserDB implements DBSet<User> {
    private static Config config = Config.getConfig("db");
    private final static String name = "user";
    public static final String lastIDPath = config.getProperty(name)+config.getProperty("lastID");
    public static final String dbPath = config.getProperty(name)+config.getProperty("db");

    @Override
    public ID getLastID() {
        File file = new File(lastIDPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                PrintStream printStream = new PrintStream(file);
                printStream.println("0");
                printStream.flush();
                printStream.close();
            } catch (FileNotFoundException e) {
                Logger.getLogger().dbError(name);
                e.printStackTrace();
            }
        }

        try {
            Scanner scanner = new Scanner(file);
            String lastID =scanner.nextLine();
            scanner.close();

            return new ID(Integer.parseInt(lastID));
        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void increaseLastID() {
        int lastIDNum = 0;
        File file = new File(lastIDPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                PrintStream printStream = new PrintStream(file);
                printStream.println(lastIDNum);
                printStream.flush();
                printStream.close();
            } catch (FileNotFoundException e) {
                Logger.getLogger().dbError(name);
                e.printStackTrace();
            }
        }
        try {
            Scanner scanner = new Scanner(file);
            String lastID =scanner.nextLine();
            scanner.close();

            lastIDNum = Integer.parseInt(lastID);

        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }

        lastIDNum++;

        try {
            PrintStream printStream = new PrintStream(file);
            printStream.println(lastIDNum);
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }
    }

    @Override
    public User get(ID id) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Gson gson = new GsonBuilder().create();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                User user = gson.fromJson(scanner.nextLine(),User.class);
                if (user.getId().equals(id)){
                    return user;
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }

        return null;
    }

    public User getByUsername(String username){
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Gson gson = new GsonBuilder().create();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                User user = gson.fromJson(scanner.nextLine(),User.class);
                if (user.getUsername().equals(username)){
                    return user;
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public LinkedList<User> getAll() {
        LinkedList<User> users = new LinkedList<>();
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Gson gson = new GsonBuilder().create();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                User user = gson.fromJson(scanner.nextLine(),User.class);
                users.add(user);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void add(User user) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Gson gson = new GsonBuilder().create();
            FileOutputStream stream = new FileOutputStream(file,true);
            PrintStream printStream = new PrintStream(stream);
            String userStr = gson.toJson(user);
            printStream.println(userStr);
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }

    }

    @Override
    public void remove(User user) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        LinkedList<User> users = getAll();
        users.removeIf(iteratedUser -> iteratedUser.getId().equals(user.getId()));

        writeList(users,file);
    }

    @Override
    public void update(User user) {
        File file = new File(dbPath);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        LinkedList<User> users = getAll();

        users.removeIf(iteratedUser -> iteratedUser.getId().equals(user.getId()));
        users.add(user);

        writeList(users,file);

    }

    @Override
    public void writeList(LinkedList<User> users, File file) {
        try {
            Gson gson = new GsonBuilder().create();
            PrintStream printStream = new PrintStream(file);
            for (User iteratedUser : users){
                String userStr = gson.toJson(iteratedUser);
                printStream.println(userStr);
            }
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger().dbError(name);
            e.printStackTrace();
        }
    }

}
