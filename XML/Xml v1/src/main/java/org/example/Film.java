
package org.example;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Film {

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("Rated")
    @Expose
    private String rated;
    @SerializedName("Released")
    @Expose
    private String released;
    @SerializedName("Runtime")
    @Expose
    private String runtime;
    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("Writer")
    @Expose
    private String writer;
    @SerializedName("Actors")
    @Expose
    private String actors;
    @SerializedName("Plot")
    @Expose
    private String plot;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Awards")
    @Expose
    private String awards;
    @SerializedName("Poster")
    @Expose
    private String poster;
    @SerializedName("Ratings")
    @Expose
    private List<Rating> ratings;
    @SerializedName("Metascore")
    @Expose
    private String metascore;
    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;
    @SerializedName("imdbVotes")
    @Expose
    private String imdbVotes;
    @SerializedName("imdbID")
    @Expose
    private String imdbID;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("DVD")
    @Expose
    private String dvd;
    @SerializedName("BoxOffice")
    @Expose
    private String boxOffice;
    @SerializedName("Production")
    @Expose
    private String production;
    @SerializedName("Website")
    @Expose
    private String website;
    @SerializedName("Response")
    @Expose
    private String response;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Film() {
    }

    /**
     * 
     * @param country
     * @param year
     * @param production
     * @param language
     * @param imdbRating
     * @param title
     * @param imdbVotes
     * @param type
     * @param dvd
     * @param plot
     * @param ratings
     * @param genre
     * @param released
     * @param website
     * @param director
     * @param imdbID
     * @param runtime
     * @param rated
     * @param actors
     * @param awards
     * @param response
     * @param writer
     * @param metascore
     * @param boxOffice
     * @param poster
     */
    public Film(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, String awards, String poster, List<Rating> ratings, String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String dvd, String boxOffice, String production, String website, String response) {
        super();
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.ratings = ratings;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.type = type;
        this.dvd = dvd;
        this.boxOffice = boxOffice;
        this.production = production;
        this.website = website;
        this.response = response;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Film.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("year");
        sb.append('=');
        sb.append(((this.year == null)?"<null>":this.year));
        sb.append(',');
        sb.append("rated");
        sb.append('=');
        sb.append(((this.rated == null)?"<null>":this.rated));
        sb.append(',');
        sb.append("released");
        sb.append('=');
        sb.append(((this.released == null)?"<null>":this.released));
        sb.append(',');
        sb.append("runtime");
        sb.append('=');
        sb.append(((this.runtime == null)?"<null>":this.runtime));
        sb.append(',');
        sb.append("genre");
        sb.append('=');
        sb.append(((this.genre == null)?"<null>":this.genre));
        sb.append(',');
        sb.append("director");
        sb.append('=');
        sb.append(((this.director == null)?"<null>":this.director));
        sb.append(',');
        sb.append("writer");
        sb.append('=');
        sb.append(((this.writer == null)?"<null>":this.writer));
        sb.append(',');
        sb.append("actors");
        sb.append('=');
        sb.append(((this.actors == null)?"<null>":this.actors));
        sb.append(',');
        sb.append("plot");
        sb.append('=');
        sb.append(((this.plot == null)?"<null>":this.plot));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("awards");
        sb.append('=');
        sb.append(((this.awards == null)?"<null>":this.awards));
        sb.append(',');
        sb.append("poster");
        sb.append('=');
        sb.append(((this.poster == null)?"<null>":this.poster));
        sb.append(',');
        sb.append("ratings");
        sb.append('=');
        sb.append(((this.ratings == null)?"<null>":this.ratings));
        sb.append(',');
        sb.append("metascore");
        sb.append('=');
        sb.append(((this.metascore == null)?"<null>":this.metascore));
        sb.append(',');
        sb.append("imdbRating");
        sb.append('=');
        sb.append(((this.imdbRating == null)?"<null>":this.imdbRating));
        sb.append(',');
        sb.append("imdbVotes");
        sb.append('=');
        sb.append(((this.imdbVotes == null)?"<null>":this.imdbVotes));
        sb.append(',');
        sb.append("imdbID");
        sb.append('=');
        sb.append(((this.imdbID == null)?"<null>":this.imdbID));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("dvd");
        sb.append('=');
        sb.append(((this.dvd == null)?"<null>":this.dvd));
        sb.append(',');
        sb.append("boxOffice");
        sb.append('=');
        sb.append(((this.boxOffice == null)?"<null>":this.boxOffice));
        sb.append(',');
        sb.append("production");
        sb.append('=');
        sb.append(((this.production == null)?"<null>":this.production));
        sb.append(',');
        sb.append("website");
        sb.append('=');
        sb.append(((this.website == null)?"<null>":this.website));
        sb.append(',');
        sb.append("response");
        sb.append('=');
        sb.append(((this.response == null)?"<null>":this.response));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.country == null)? 0 :this.country.hashCode()));
        result = ((result* 31)+((this.year == null)? 0 :this.year.hashCode()));
        result = ((result* 31)+((this.production == null)? 0 :this.production.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.imdbRating == null)? 0 :this.imdbRating.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.imdbVotes == null)? 0 :this.imdbVotes.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.dvd == null)? 0 :this.dvd.hashCode()));
        result = ((result* 31)+((this.plot == null)? 0 :this.plot.hashCode()));
        result = ((result* 31)+((this.ratings == null)? 0 :this.ratings.hashCode()));
        result = ((result* 31)+((this.genre == null)? 0 :this.genre.hashCode()));
        result = ((result* 31)+((this.released == null)? 0 :this.released.hashCode()));
        result = ((result* 31)+((this.website == null)? 0 :this.website.hashCode()));
        result = ((result* 31)+((this.director == null)? 0 :this.director.hashCode()));
        result = ((result* 31)+((this.imdbID == null)? 0 :this.imdbID.hashCode()));
        result = ((result* 31)+((this.runtime == null)? 0 :this.runtime.hashCode()));
        result = ((result* 31)+((this.rated == null)? 0 :this.rated.hashCode()));
        result = ((result* 31)+((this.actors == null)? 0 :this.actors.hashCode()));
        result = ((result* 31)+((this.awards == null)? 0 :this.awards.hashCode()));
        result = ((result* 31)+((this.response == null)? 0 :this.response.hashCode()));
        result = ((result* 31)+((this.writer == null)? 0 :this.writer.hashCode()));
        result = ((result* 31)+((this.metascore == null)? 0 :this.metascore.hashCode()));
        result = ((result* 31)+((this.boxOffice == null)? 0 :this.boxOffice.hashCode()));
        result = ((result* 31)+((this.poster == null)? 0 :this.poster.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Film) == false) {
            return false;
        }
        Film rhs = ((Film) other);
        return ((((((((((((((((((((((((((this.country == rhs.country)||((this.country!= null)&&this.country.equals(rhs.country)))&&((this.year == rhs.year)||((this.year!= null)&&this.year.equals(rhs.year))))&&((this.production == rhs.production)||((this.production!= null)&&this.production.equals(rhs.production))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.imdbRating == rhs.imdbRating)||((this.imdbRating!= null)&&this.imdbRating.equals(rhs.imdbRating))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.imdbVotes == rhs.imdbVotes)||((this.imdbVotes!= null)&&this.imdbVotes.equals(rhs.imdbVotes))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.dvd == rhs.dvd)||((this.dvd!= null)&&this.dvd.equals(rhs.dvd))))&&((this.plot == rhs.plot)||((this.plot!= null)&&this.plot.equals(rhs.plot))))&&((this.ratings == rhs.ratings)||((this.ratings!= null)&&this.ratings.equals(rhs.ratings))))&&((this.genre == rhs.genre)||((this.genre!= null)&&this.genre.equals(rhs.genre))))&&((this.released == rhs.released)||((this.released!= null)&&this.released.equals(rhs.released))))&&((this.website == rhs.website)||((this.website!= null)&&this.website.equals(rhs.website))))&&((this.director == rhs.director)||((this.director!= null)&&this.director.equals(rhs.director))))&&((this.imdbID == rhs.imdbID)||((this.imdbID!= null)&&this.imdbID.equals(rhs.imdbID))))&&((this.runtime == rhs.runtime)||((this.runtime!= null)&&this.runtime.equals(rhs.runtime))))&&((this.rated == rhs.rated)||((this.rated!= null)&&this.rated.equals(rhs.rated))))&&((this.actors == rhs.actors)||((this.actors!= null)&&this.actors.equals(rhs.actors))))&&((this.awards == rhs.awards)||((this.awards!= null)&&this.awards.equals(rhs.awards))))&&((this.response == rhs.response)||((this.response!= null)&&this.response.equals(rhs.response))))&&((this.writer == rhs.writer)||((this.writer!= null)&&this.writer.equals(rhs.writer))))&&((this.metascore == rhs.metascore)||((this.metascore!= null)&&this.metascore.equals(rhs.metascore))))&&((this.boxOffice == rhs.boxOffice)||((this.boxOffice!= null)&&this.boxOffice.equals(rhs.boxOffice))))&&((this.poster == rhs.poster)||((this.poster!= null)&&this.poster.equals(rhs.poster))));
    }

}
