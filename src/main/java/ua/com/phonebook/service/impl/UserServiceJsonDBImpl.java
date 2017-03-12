package ua.com.phonebook.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.phonebook.entity.CustomUser;
import ua.com.phonebook.entity.enums.UserRole;
import ua.com.phonebook.service.UserService;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Implementation of {@link UserService} interface to store data in JSON files.
 *
 * @author Maxim Beseda
 * @version 1.0
 */


public class UserServiceJsonDBImpl implements UserService {

    private static String jsonDataBasePath;
    private Gson gson = new GsonBuilder().create();

    public UserServiceJsonDBImpl() {
        createFolder();
    }

    private void createFolder() {
        File folder = new File(jsonDataBasePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    @Override
    public CustomUser addUser(CustomUser customUser) {
        customUser.setPassword(sha1(customUser.getPassword()));
        customUser.setUserRole(UserRole.USER);
        File user = new File(jsonDataBasePath + "/" + customUser.getLogin() + ".json");
        String userJson = gson.toJson(customUser);
        saveToFile(user, userJson);
        return customUser;
    }

    private void saveToFile(File file, String json) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            file.createNewFile();
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomUser editUser(CustomUser customUser) {
        File file = new File(jsonDataBasePath + "/" + customUser.getLogin() + ".json");
        String userJson = gson.toJson(customUser);
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(userJson);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customUser;
    }

    @Override
    public CustomUser getByLogin(String login) {
        File file = new File(jsonDataBasePath + "/" + login + ".json");
        if (!file.exists()) {
            return null;
        }
        return this.getUserFromFile(file);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public CustomUser getById(long id) {
        return null;
    }

    @Override
    public CustomUser getByFullName(String fullName) {
        return null;
    }

    @Override
    public List<CustomUser> getAll() {
        return null;
    }

    private CustomUser getUserFromFile(File file) {
        CustomUser user = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            user = gson.fromJson(sb.toString(), CustomUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String sha1(String input) {
        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static String getJsonDataBasePath() {
        return jsonDataBasePath;
    }

    public static void setJsonDataBasePath(String jsonDataBasePath) {
        UserServiceJsonDBImpl.jsonDataBasePath = jsonDataBasePath;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}