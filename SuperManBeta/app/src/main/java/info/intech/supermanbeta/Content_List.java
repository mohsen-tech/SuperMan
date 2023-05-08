package info.intech.supermanbeta;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Amin2 on 8/26/2017.
 */

public class Content_List {


    public int currPage = 0, itemsCount = 0, pagesCount = 0;
    public Content_Item[] items;

    public Content_List(JSONObject object) throws JSONException {

        this.currPage = object.getInt("currPage");

        this.itemsCount = object.getInt("itemsCount");

        this.pagesCount = object.getInt("pagesCount");

    }

    public Content_List(int currPage, int itemsCount, int pagesCount) {

        this.currPage = currPage;

        this.itemsCount = itemsCount;

        this.pagesCount = pagesCount;
    }

    public int getcurrPage() {
        return currPage;
    }

    public void setcurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getitemsCount() {
        return itemsCount;
    }

    public void setitemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public int getpagesCount() {
        return pagesCount;
    }

    public void setpagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
}
