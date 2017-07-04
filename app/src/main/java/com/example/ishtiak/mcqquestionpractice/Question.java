package com.example.ishtiak.mcqquestionpractice;

/**
 * Created by Ishtiak on 6/22/2017.
 */

public class Question {
    private  int ID;
    private  String QUESTION;
    private  String OPTA;
    private  String OPTB;
    private  String OPTC;
    private  String ANSWER;

    public Question() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        ANSWER = "";
    }

    public Question(String qUESTION, String oPTA, String oPTB, String oPTC, String aNSWER) {
        this.QUESTION = qUESTION;
        this.OPTA = oPTA;
        this.OPTB = oPTB;
        this.OPTC = oPTC;
        this.ANSWER = aNSWER;
    }



    public int getID()
    {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTA;
    }
    public String getOPTB() {
        return OPTB;
    }
    public String getOPTC() {
        return OPTC;
    }
    public String getANSWER() {
        return ANSWER;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }
    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }

}
