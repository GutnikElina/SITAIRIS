package com.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MovieXMLHandler extends DefaultHandler {
    MovieCatalog myCatalog = null;
    Movie movie = null;

    // Флаги для отслеживания текущего тега
    boolean director = false;
    boolean title = false;
    boolean description = false;
    String currentCharacters;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("catalog")) {
            myCatalog = new MovieCatalog();
        } else if (qName.equalsIgnoreCase("movie")) {
            movie = new Movie();
        } else if (qName.equalsIgnoreCase("director")) {
            director = true;
        } else if (qName.equalsIgnoreCase("title")) {
            title = true;
        } else if (qName.equalsIgnoreCase("description")) {
            description = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("catalog")) {
            System.out.println("-------------------------");
            System.out.println("Done with catalog");
            System.out.println(myCatalog.toString());
        } else if (qName.equalsIgnoreCase("movie")) {
            myCatalog.addMovie(movie);
            System.out.println(movie);
        } else if (qName.equalsIgnoreCase("director")) {
            movie.setDirector(currentCharacters);
            director = false;
        } else if (qName.equalsIgnoreCase("title")) {
            movie.setTitle(currentCharacters);
            title = false;
        } else if (qName.equalsIgnoreCase("description")) {
            movie.setDescription(currentCharacters);
            description = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        currentCharacters = new String(ch, start, length);
    }
}
