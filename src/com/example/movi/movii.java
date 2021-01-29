package com.example.movi;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;


public class movii {
    public static void main(String[] args)throws Exception {


        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter User Id- ");
        int us_id= sc.nextInt();
       // TopMovieByGenre.top_by_genre(0);
       // TopListOfMoviesByGenre.top_list_by_genre(0,9    );
        Top5MoviesByUserInterest.findtop5(us_id);

    }

}
