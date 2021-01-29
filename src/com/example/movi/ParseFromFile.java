package com.example.movi;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ParseFromFile {

    public static void parsing_user(List<User> u) throws IOException {

      //  File file = new File("C:\\Users\\sapna.goyal\\Downloads\\user.data");
        File file = new File("src/DataFiles/user.data");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            String[] parts = string.split(Pattern.quote("|"));
            User dummy = new User();
            dummy.userid= Integer.parseInt(parts[0]);
            dummy.age= Integer.parseInt(parts[1]);
            dummy.gender=parts[2];
            dummy.occupation=parts[3];
            dummy.zipcode=parts[4];
           /* System.out.println(parts[0]);
            System.out.println(string);*/

            u.add(dummy);
        }

    }
    public static void parsing_rating(List<Rating> r) throws IOException{
    //    File file = new File("C:\\Users\\sapna.goyal\\Downloads\\ratings.data");
        File file = new File("src/DataFiles/ratings.data");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            StringTokenizer parts = new StringTokenizer(st);
            Rating dummy = new Rating();
            dummy.UserId= Integer.parseInt(parts.nextToken());
            dummy.ItemId= Integer.parseInt(parts.nextToken());
            dummy.rating= Integer.parseInt(parts.nextToken());
          /*  System.out.println(parts.nextToken());
            System.out.println(string);*/

            r.add(dummy);
        }

    }
    public static void parsing_movie(List<Movie> m) throws IOException {
       // File file = new File("C:\\Users\\sapna.goyal\\Downloads\\movie.data");
        File file = new File("src/DataFiles/movie.data");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            String[] parts = string.split(Pattern.quote("|"));
            Movie dummy = new Movie();
            dummy.movieId= Integer.parseInt(parts[0]);
            dummy.movieTitle=parts[1];
            dummy.releaseDate=parts[2];
            dummy.IMDbURL=parts[4];
         /*   System.out.println(parts[3]);
            System.out.println(string);*/
            for(int i=0;i<19;i++){
                dummy.genre.add(Integer.parseInt(parts[i+5]));
            }
            m.add(dummy);
        }
    }
    public static void parsing_genre(List<Genre> g) throws IOException {

       // File file = new File("C:\\Users\\sapna.goyal\\Downloads\\genre.data");
        File file = new File("src/DataFiles/genre.data");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String string = st;
            String[] parts = string.split(Pattern.quote("|"));
            Genre dummy = new Genre();
            if(parts.length==2) {
                dummy.genrename = parts[0];
                dummy.genreid = Integer.parseInt(parts[1]);
               /* System.out.println(parts[1]);
                System.out.println(string);*/
            }
            g.add(dummy);
        }


    }

}
