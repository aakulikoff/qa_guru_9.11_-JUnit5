package qa;

public enum SearchItem {
    PS5 ("PlayStation 5"),
    XBOX ("Microsoft Xbox Series ") ;

    private String searchItem;

    SearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public String getSearchItem() {
        return searchItem;
    }


}
