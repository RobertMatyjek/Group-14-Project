package com.recipease.recipease;

import java.util.ArrayList;

/**
 * Created by robert matyjek on 2/19/2018.
 */

public class Recipe {
    private String title;
    private int userID;
    private int recipeID;
    private ArrayList<Integer> cookingInstructions;
    private ArrayList<Integer> ingredientMeasurements;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public ArrayList<Integer> getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(ArrayList<Integer> cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    public ArrayList<Integer> getIngredientMeasurements() {
        return ingredientMeasurements;
    }

    public void setIngredientMeasurements(ArrayList<Integer> ingredientMeasurements) {
        this.ingredientMeasurements = ingredientMeasurements;
    }

    //public void addCookingInstruction(Instruction newInstruction){
        //Needs to still be implemented. This essentially adds an instruction object to the ArrayList called cookingInstruction.
        //Conversion between object and ID also needs to occur
        //Relies on the instruction class
    //}

    public void removeCookingInstruction(int instructionID){
        //Needs to still be implemented.
        //Uses some time of search to find specified element and then remove it from the list.
    }

    //public void addIngredientMeasurement(MeasuredIngredient newMeasuredIngredient){
        //Needs to still be implemented,
        //Relies on the MeasuredIngredient class
   // }

    public void removeIngredientMeasurement(){
        //Needs to still be implemented
    }


}
