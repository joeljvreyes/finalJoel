package com.example.exfinaljv;

import java.util.Collection;
import java.util.List;

public class APIResponse {
    private List<Results> results;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results {
        private Name name;
        private Location location;
        private String email;
        private Picture picture;

        // Getters and setters
        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Picture getPicture() {
            return picture;
        }

        public void setPicture(Picture picture) {
            this.picture = picture;
        }
    }

    public static class Name {
        private String first;
        private String last;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }

    public static class Location {
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public static class Picture {
        private String large;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
    }
}