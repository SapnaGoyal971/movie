package com.example.movi;

        import java.io.IOException;
        import java.util.*;

public class TopListOfMoviesByGenre {

    public static HashMap<Integer, Float> sortByValue(HashMap<Integer, Float> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Float> > list =
                new LinkedList<Map.Entry<Integer, Float> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Float> >() {
            public int compare(Map.Entry<Integer, Float> o1,
                               Map.Entry<Integer, Float> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        // put data from sorted list to hashmap
        HashMap<Integer, Float> temp = new LinkedHashMap<Integer, Float>();
        for (Map.Entry<Integer, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    public static int userhasnotseen(int usid,int movieid, List<Rating> ra){
        for(int i=0;i<ra.size();i++){
            if(ra.get(i).UserId==usid && ra.get(i).ItemId==movieid)
                return 0;
        }
        return 1;
    }

    public static void top_list_by_genre(int gen,int us_id) throws IOException {
        List<Movie> mo =new ArrayList<Movie>() ;
        ParseFromFile.parsing_movie(mo);
/////////////////////////////////////////////////////////////
        List<Integer> movie_ids=new ArrayList<>();   //To get the list of movie id's with the given genre gen
        for(int i=0;i<mo.size();i++){
            if(mo.get(i).genre.get(gen)==1)
                movie_ids.add(mo.get(i).movieId); //Add that movie id to movie_ids whose genre is same as our genre gen
        }

       /* for(int i=0;i<movie_ids.size();i++){
            System.out.println(movie_ids.get(i));
        }*/
///////////////////////////////////////////////////////////////

        List<Rating> ra =new ArrayList<Rating>() ;
        ParseFromFile.parsing_rating(ra);
        HashMap<Integer, Float> hm = new HashMap<Integer, Float>(); //To get total average rating of the movie based on users given rating

            for(int j=0;j<movie_ids.size();j++) {
            int sum=0;
            int count=0;
            for (int i = 0; i < ra.size(); i++) {
                if (ra.get(i).ItemId ==movie_ids.get(j)){
                    sum+=ra.get(i).rating; //add rating to our movie j if user's movie i is same as our movie j.
                    count++; //increase the count of movie if our movie j is same as user's movie i.
                }
            }
            float avg= sum/(float)count; //this is average total rating of our movie j
            if(userhasnotseen(us_id,movie_ids.get(j),ra)==1)
            hm.put(movie_ids.get(j),avg);
        }
        Map<Integer, Float> hm1 = sortByValue(hm); //sort movies based on their average rating in descending order.

            int coun=0; //In order to keep count of first 5 movies
        for (Map.Entry<Integer, Float> en : hm1.entrySet()) {
            if(coun==5)
                break;
            System.out.println((coun+1)+": Movie Id "+" = " + en.getKey() +
                    ", Rating = " + en.getValue());  //Print the movie id and their average rating
            coun++;
        }
//////////////////////////////////////////////////



    }
}


