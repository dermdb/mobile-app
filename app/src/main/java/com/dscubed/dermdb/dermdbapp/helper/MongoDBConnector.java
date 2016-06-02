package com.dscubed.dermdb.dermdbapp.helper;

import android.graphics.Bitmap;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

import org.bson.Document;

import java.io.ByteArrayOutputStream;

/**
 * Created by dmarques on 02/06/2016.
 */
public class MongoDBConnector {

    public static void saveImage(Bitmap bitmap, String filename) {
        try {
            // TODO: Hard-coded data; should be read from a config file
            MongoClient mongo = new MongoClient("localhost", 27017);
            MongoDatabase db = mongo.getDatabase("imagedb");
            MongoCollection<Document> collection = db.getCollection("dummyColl");

            //Converting input bitmap to byte array
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] bitmapAsByteArray = stream.toByteArray();

            // Saving image on mongoDB collection
            // Creating instance of GridFS
            GridFS gridFS = new GridFS((DB) db);
            // Creating file using byte array
            GridFSInputFile gridFSInputFile = gridFS.createFile(bitmapAsByteArray);

            //Set a name on GridFS entry
            gridFSInputFile.setFilename("image1");
            //Save the file to MongoDB
            gridFSInputFile.save();
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }

}
