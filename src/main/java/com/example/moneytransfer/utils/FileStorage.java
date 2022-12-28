package com.example.moneytransfer.utils;

import com.example.moneytransfer.model.Card;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileStorage {

    private static String filePath;
    private static final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";
    private static final String UNCONFIRMED_STATUS = "UNCONFIRMED";
    private static final String CONFIRMED_STATUS = "CONFIRMED";

    public static void createStorageFileIfNotExists(String filePath) {
        //File storageFile = new File(filePath);
        FileStorage.filePath = filePath;
        try {
            Files.createFile(Path.of(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveToFileStorage(String id, Card card) throws IOException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        String today = formatter.format(date);
        FileOutputStream stream = new FileOutputStream(filePath, true);
        FileChannel channel = stream.getChannel();
        FileLock lock = null;
        try {
            lock = channel.tryLock();
        } catch (final OverlappingFileLockException e) {
            stream.close();
            channel.close();
        }
        String message;
        if (card != null) {
            message = today + " " + id + " " + card.getCardFromNumber() + " " + card.getCardFromValidTill() + " " +
                    card.getCardToNumber() + " " + card.getAmount().getValue() + " " + card.getAmount().getCurrency() +
                    " " + UNCONFIRMED_STATUS + '\n';
        } else {
            message = today + " " + id + " " + CONFIRMED_STATUS + "\n";
        }
        byte[] strToBytes = message.getBytes();
        stream.write(strToBytes);
        lock.release();
        stream.close();
        channel.close();
    }
}
