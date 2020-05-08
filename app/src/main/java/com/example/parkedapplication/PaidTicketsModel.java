package com.example.parkedapplication;

public class PaidTicketsModel{


    private String Date;
    private String Agent_nbr;
    private String Ticket_price;
    private int Plate;

    public PaidTicketsModel() {
    }

    public PaidTicketsModel(String date, String agent_nbr, String ticket_price, int plate) {
        Date = date;
        Agent_nbr = agent_nbr;
        Ticket_price = ticket_price;
        Plate = plate;
    }

    //getters
    public String getDate() {
        return Date;
    }

    public String getAgent_nbr() {
        return Agent_nbr;
    }

    public String getTicket_price() {
        return Ticket_price;
    }

    public int getPlate() {
        return Plate;
    }

    //setters

    public void setDate(String date) {
        Date = date;
    }

    public void setAgent_nbr(String agent_nbr) {
        Agent_nbr = agent_nbr;
    }

    public void setTicket_price(String ticket_price) {
        Ticket_price = ticket_price;
    }

    public void setPlate(int plate) {
        Plate = plate;
    }

}
