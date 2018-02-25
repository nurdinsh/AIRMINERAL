package com.example.nurdiansyah.sc3;

class Mineral {
        private String title;
        private String info;
        private final int imageResource;

        /**
         * Constructor for the Sport data model
         * @param title The name if the sport.
         * @param info Information about the sport.
         *
         */
        public Mineral(String title, String info, int imageResource) {
            this.title = title;
            this.info = info;
            this.imageResource = imageResource;
        }

        /**
         * Gets the title of the sport
         * @return The title of the sport.
         */
        String getTitle() {
            return title;
        }
        /**
         * Gets the info about the sport
         * @return The info about the sport.
         */
        String getInfo() {
            return info;
        }

        public int getImageResource() {
            return imageResource;
        }
}
