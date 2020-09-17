package com.athnitech.services;

import com.athnitech.model.Trainee;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

  private final FirebaseInitializer firebaseDB;

  @Autowired
  public RegisterService(FirebaseInitializer firebaseDB) {
    this.firebaseDB = firebaseDB;
  }

  private CollectionReference getCollectionReference() {
    return firebaseDB.getFirebase().collection("trainees");
  }

  public List<Trainee> getDocumentSnapshot()
      throws ExecutionException, InterruptedException {
    List<Trainee> trainees = new ArrayList<>();
    ApiFuture<QuerySnapshot> querySnapshot = getCollectionReference().get();

    if (querySnapshot.get().getDocuments().size() > 0) {
      querySnapshot.get().getDocuments()
          .forEach(documentSnapshot -> trainees.add(documentSnapshot.toObject(Trainee.class)));
    }
    return trainees;
  }

  public long registerTrainee(Trainee trainee) {
    CollectionReference collectionRef = getCollectionReference();
    collectionRef.document(String.valueOf(trainee.getId())).set(trainee);
    return trainee.getId();
  }

}
