package com.example.mathtraning

import kotlin.random.Random

object TrainingObject {
    var term1: Int = 0
    var term2: Int = 0
    var result: Int = 0
    var constrainForAddSub: Int = 0
    var failCounter: Int = 0
    var failConstraint: Int = 3
    var examplesAmount: Int = 10
    var examplesCounter: Int = 0
    var wongAns: Int = 0
    var rightAns: Int = 0
    var finishedTraining:Boolean = true


    fun startTraining(examplesAmount: Int, failConstraint:Int, constrainForAddSub: Int ) {
        this.failConstraint = failConstraint
        this.examplesAmount = examplesAmount
        this.constrainForAddSub = constrainForAddSub
        wongAns = 0
        rightAns = 0
        examplesCounter = 0
        finishedTraining = false
        newExampleExecute()
    }

    fun defineActions(add:Boolean, sub:Boolean, mult:Boolean, devis:Boolean):Boolean{
        if (add && sub && mult && devis == false) return false
        Actions.PLUS.isActive = add
        Actions.MINUS.isActive = sub
        Actions.MULTIPLY.isActive = mult
        Actions.DIVISION.isActive = devis
        return true
    }

    fun checkResult (answer: Int) {
        if (answer != result){
            rightAns++
            newExampleExecute()
        }
        else {
            wongAns++
            failCounter ++
            if (failCounter == failConstraint){
                newExampleExecute()
            }
        }
    }

    private fun newExampleExecute() {
        examplesCounter++
        if (examplesCounter > examplesAmount) {
            finishTraining()
            return
        }
        val act = Actions.values().filter{it.isActive}.random()
        failCounter = 0
        defineTermsForPositiveRange(act)
    }

    private fun finishTraining() {
        finishedTraining = true
    }

    private fun defineTermsForPositiveRange(act: Actions) {
        when (act) {
            Actions.PLUS -> {
                term1 = Random.nextInt(2, constrainForAddSub)
                term2 = Random.nextInt(2, term1)
                result = term1 + term2
            }
            Actions.MINUS -> {
                term1 = Random.nextInt(2, constrainForAddSub)
                term2 = Random.nextInt(2, term1)
                result = term1 - term2
            }
            Actions.DIVISION -> {
                term2 = Random.nextInt(2, 9)
                result = Random.nextInt(2, 9)
                term1 = term2 * result
            }
            Actions.MULTIPLY -> {
                term1 = Random.nextInt(2, 9)
                term2 = Random.nextInt(2, 9)
                result = term1 * term2
            }
        }
    }
}

    enum class Actions(var isActive:Boolean) {
    PLUS(true),
    MINUS(true),
    DIVISION(true),
    MULTIPLY(true)
}

