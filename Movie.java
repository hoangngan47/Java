import java.util.ArrayList;

public class Movie {
    private String title;
    private int duration;
    private double rating;
    
    public Movie(String title, int duration, double rating) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
    }
    
    public void hienThiThongTin() {
        System.out.println("Ten phim: " + title);
        System.out.println("So phut: " + duration);
        System.out.println("Danh gia: " + rating);
    }
    
    public String getTitle() {return title;}
    public int getDuration() {return duration;}
    public double getRating() {return rating;}
}


class Cinema {
    private ArrayList<Movie> movies;
    static int totalMovies = 0;

    public Cinema() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie m) {
        movies.add(m);
        totalMovies++; 
    }
    
    public static void hienThiTongSoPhim() {
        System.out.println("Tong so phim: " + totalMovies);
    }
    
    public void showMovies() {
        System.out.println("Danh sach phim trong rap:");
        for (Movie m : movies) {
            m.hienThiThongTin();
        }
    }

    public void showLongMovies() {
        System.out.println("Danh sach phim co thoi luong > 120 phut:");
        for (Movie m : movies) {
            if (m.getDuration() > 120) {
                System.out.println(m.getTitle());
            }
        }
    }
}



class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        Movie mv01 = new Movie("Mua Do", 130, 9.0);
        Movie mv02 = new Movie("Conan", 120, 8.0);
        Movie mv03 = new Movie("Ironman", 180, 9.5);
        Movie mv04 = new Movie("Thanh guom diet quy", 135, 9.5);

        cinema.addMovie(mv01);
        cinema.addMovie(mv02);
        cinema.addMovie(mv03);
        cinema.addMovie(mv04);

        cinema.showMovies();        
        Cinema.hienThiTongSoPhim();
        cinema.showLongMovies();    
    }
}

