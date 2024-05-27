package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;

    private static  ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[] {personne.ageProperty()});

        unChangementListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                change.next();
                if (change.wasAdded() == true) {
                    System.out.println("Ajout de : " + change.getAddedSubList().get(0).getNom());
                }
                else if (change.wasRemoved() == true) {
                    System.out.println("Retrait de : " + change.getRemoved().get(0).getNom());
                }
                else if (change.wasUpdated() == true) {
                    System.out.println(change.getList().get(change.getFrom()).getNom() + " a maintenant " + change.getList().get(change.getFrom()).getAge() + " ans");
                }
                System.out.println("Test");
            }
        };

        plusieursChangementsListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                while (change.next()) {
                    if (change.wasAdded() == true) {
                        for (int i = 0; i < change.getAddedSize(); ++i) {
                            System.out.println("Ajout de : " + change.getAddedSubList().get(i).getNom());
                        }
                    }
                    else if (change.wasRemoved() == true) {
                        for (int i = 0; i < change.getRemovedSize(); ++i){
                            System.out.println("Retrait de : " + change.getRemoved().get(i).getNom());
                        }
                    }
                    else if (change.wasUpdated() == true) {
                        for (int i = 0; i < change.getList().size(); ++i){
                            if (change.getList().get(i).getAge() == 0){
                                System.out.println("L'age de " + change.getList().get(i).getNom() + " n'a pas changé");
                            }
                            else System.out.println(change.getList().get(i).getNom() + " a maintenant " + change.getList().get(i).getAge() + " ans");
                        }
                    }
                }
                System.out.println("Test");
            }
        };

        lesPersonnes.addListener(plusieursChangementsListener);
        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

