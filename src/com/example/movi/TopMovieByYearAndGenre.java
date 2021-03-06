package com.example.movi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopMovieByYearAndGenre {
    public static void topmoviebyyearandgenre(int yr, int gen) throws IOException {
        List<Movie> mo =new ArrayList<Movie>() ;
        ParseFromFile.parsing_movie(mo);
        /////////////////////////////////////////////////////////////
        List<Integer> movie_ids=new ArrayList<>();   //To get the list of movie id's with the given genre gen
        for(int i=0;i<mo.size();i++){
            String curryear=mo.get(i).releaseDate;
            int curryr=-1;
            if(curryear.length()>=4)
                curryr=Integer.parseInt(curryear.substring(curryear.length()-4,curryear.length()));
            if(curryr==yr && mo.get(i).genre.get(gen)==1)
                movie_ids.add(mo.get(i).movieId);
        }

        if(movie_ids.isEmpty())
            System.out.println("No movie released in this year");
       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/
///////////////////////////////////////////////////////////////
        List<Rating> ra =new ArrayList<Rating>() ;
        ParseFromFile.parsing_rating(ra);

        int top_average_rating_movie_id_by_year=-1;

        float maxx=0;
        for(int j=0;j<movie_ids.size();j++) {
            int sum=0;
            int count=0;
            for (int i = 0; i < ra.size(); i++) {
                if (ra.get(i).ItemId ==movie_ids.get(j)){
                    sum+=ra.get(i).rating;
                    count++;
                }
            }
            float avg= sum/(float)count;
            if(maxx<avg){
                maxx=avg;
                top_average_rating_movie_id_by_year=movie_ids.get(j);
            }
        }

        if(!movie_ids.isEmpty())
        System.out.println("Top Movie Id By Year " + yr + " and genre " + gen + ": "+top_average_rating_movie_id_by_year);
      //  System.out.println(maxx);
        if(!movie_ids.isEmpty())
        System.out.println("Top Movie Name By Year " + yr + " and genre " + gen + ": "+mo.get(top_average_rating_movie_id_by_year).movieTitle);

    }
}
