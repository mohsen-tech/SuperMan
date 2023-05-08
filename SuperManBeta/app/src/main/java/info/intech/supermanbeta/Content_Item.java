package info.intech.supermanbeta;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Amin2 on 8/26/2017.
 */
public class Content_Item {

    private String archiveDate = "", brief = "", catName = "";
    private String createDate = "";
    private String name = "";
    private String nav = "";
    private String publishDate = "";
    private String reference = "";
    private String referenceLink = "";
    private String scatName = "";
    private String tags = "";
    private String url = "";
    private String writer = "";
    private String icon = "";

    private int catId = -1;
    private int cmdCount = 0;
    private int id = -1;
    private int isArchive = 0;
    private int rate = 0;
    private int scatId = -1;

    public Content_Item(JSONObject object) throws JSONException {

        this.archiveDate = object.getString("archiveDate");

        this.brief = object.getString("brief");

        this.catId = object.getInt("catId");

        this.catName = object.getString("catName");

        this.cmdCount = object.getInt("cmdCount");

        this.createDate = object.getString("createDate");

        this.icon = object.getString("icon");

        this.id = object.getInt("id");

        this.isArchive = object.getInt("isArchive");

        this.name = object.getString("name");

        this.nav = object.getString("nav");

        this.publishDate = object.getString("publishDate");

        this.rate = object.getInt("rate");

        this.reference = object.getString("reference");

        this.referenceLink = object.getString("referenceLink");

        this.scatId = object.getInt("scatId");

        this.scatName = object.getString("scatName");

        this.tags = object.getString("tags");

        this.url = object.getString("url");

        this.writer = object.getString("writer");

    }

    public Content_Item(String archiveDate, String brief, int catId, String catName, int cmdCount
            , String createDate, String icon, int id, int isArchive, String name, String nav,
                        String publishDate, int rate, String reference, String referenceLink,
                        int scatId, String scatName, String tags, String url, String writer) {

        this.archiveDate = archiveDate;

        this.brief = brief;

        this.catId = catId;

        this.catName = catName;

        this.cmdCount = cmdCount;

        this.createDate = createDate;

        this.icon = icon;

        this.id = id;

        this.isArchive = isArchive;

        this.name = name;

        this.nav = nav;

        this.publishDate = publishDate;

        this.rate = rate;

        this.reference = reference;

        this.referenceLink = referenceLink;

        this.scatId = scatId;

        this.scatName = scatName;

        this.tags = tags;

        this.url = url;

        this.writer = writer;
    }

    public String getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(String archiveDate) {
        this.archiveDate = archiveDate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCmdCount() {
        return cmdCount;
    }

    public void setCmdCount(int cmdCount) {
        this.cmdCount = cmdCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(int isArchive) {
        this.isArchive = isArchive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceLink() {
        return referenceLink;
    }

    public void setReferenceLink(String referenceLink) {
        this.referenceLink = referenceLink;
    }

    public int getScatId() {
        return scatId;
    }

    public void setScatId(int scatId) {
        this.scatId = scatId;
    }

    public String getScatName() {
        return scatName;
    }

    public void setScatName(String scatName) {
        this.scatName = scatName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}