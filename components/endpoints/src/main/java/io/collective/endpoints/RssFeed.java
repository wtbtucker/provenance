package io.collective.endpoints;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement(localName = "rss")
public class RssFeed {

    private Channel channel;

    @JsonCreator
    public RssFeed(@JsonProperty("channel") Channel channel) {
        this.channel = channel;
    }

    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public class Channel {

        private String title;
        private String link;
        private String description;
        private List<Item> items;


        public Channel(
                @JsonProperty("title") String title,
                @JsonProperty("link") String link,
                @JsonProperty("description") String description,
                @JsonProperty("item") List<Item> items) {
            this.title = title;
            this.link = link;
            this.description = description;
            this.items = items;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("link")
        public String getLink() {
            return link;
        }

        @JsonProperty("link")
        public void setLink(String link) {
            this.link = link;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("item")
        @JacksonXmlElementWrapper(useWrapping = false)
        public List<Item> getItems() {
            return items;
        }

        @JsonProperty("item")
        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    public class Item {

        private String title;
        private String link;
        private String description;
        private List<String> categories;
        private String pubDate;
        private String guid;
        private String dc;


        public Item(
                @JsonProperty("title") String title,
                @JsonProperty("link") String link,
                @JsonProperty("description") String description,
                @JsonProperty("category") List<String> categories,
                @JsonProperty("pubDate") String pubDate) {
            this.title = title;
            this.link = link;
            this.description = description;
            this.categories = categories;
            this.pubDate = pubDate;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("link")
        public String getLink() {
            return link;
        }

        @JsonProperty("link")
        public void setLink(String link) {
            this.link = link;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("category")
        @JacksonXmlElementWrapper(useWrapping = false)
        public List<String> getCategories() {
            return categories;
        }

        @JsonProperty("category")
        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        @JsonProperty("pubDate")
        public String getPubDate() {
            return pubDate;
        }

        @JsonProperty("pubDate")
        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }
    }
}

