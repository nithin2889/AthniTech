package com.athnitech.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class FirebaseInitializer {

  @PostConstruct
  private void initFirebaseDB() throws IOException {

    InputStream serviceAccount = this.getClass().getClassLoader()
        .getResourceAsStream("./athnitech-firebase-adminsdk-svata-485ef4c5d0.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://athnitech.firebaseio.com")
        .build();

    if (FirebaseApp.getApps().isEmpty()) {
      FirebaseApp.initializeApp(options);
    }
  }

  public Firestore getFirebase() {
    return FirestoreClient.getFirestore();
  }
}
