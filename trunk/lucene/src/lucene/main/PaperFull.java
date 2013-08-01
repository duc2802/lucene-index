/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lucene.main;

/**
 *
 * @author THNghiep
 */
public class PaperFull {
    private String idPaper;
    private String doi;
    private String isbn;
    private String url;
    private String title;
    private String abstractContent;
    private String volume;
    private String pages;
    private String year;
    private String viewPublication;
    private String bibTex;
    private String endNote;
    private String version;
    private String paperFile;
    private String authorNames;
    private String journalName;
    private String conferenceName;
    private String keywords;
    private String idPaperRefs;

    public PaperFull(){
        
    }

    /**
     * @return the idPaper
     */
    public String getIdPaper() {
        return idPaper;
    }

    /**
     * @param idPaper the idPaper to set
     */
    public void setIdPaper(String idPaper) {
        this.idPaper = idPaper;
    }

    /**
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the abstractContent
     */
    public String getAbstractContent() {
        return abstractContent;
    }

    /**
     * @param abstractContent the abstractContent to set
     */
    public void setAbstractContent(String abstractContent) {
        if(abstractContent == null) {
            this.abstractContent = " ";
        }
        else {
            this.abstractContent = abstractContent;
        }
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the pages
     */
    public String getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the viewPublication
     */
    public String getViewPublication() {
        return viewPublication;
    }

    /**
     * @param viewPublication the viewPublication to set
     */
    public void setViewPublication(String viewPublication) {
        this.viewPublication = viewPublication;
    }

    /**
     * @return the bibTex
     */
    public String getBibTex() {
        return bibTex;
    }

    /**
     * @param bibTex the bibTex to set
     */
    public void setBibTex(String bibTex) {
        this.bibTex = bibTex;
    }

    /**
     * @return the endNote
     */
    public String getEndNote() {
        return endNote;
    }

    /**
     * @param endNote the endNote to set
     */
    public void setEndNote(String endNote) {
        this.endNote = endNote;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the paperFile
     */
    public String getPaperFile() {
        return paperFile;
    }

    /**
     * @param paperFile the paperFile to set
     */
    public void setPaperFile(String paperFile) {
        this.paperFile = paperFile;
    }

    /**
     * @return the authorNames
     */
    public String getAuthorNames() {
        return authorNames;
    }

    /**
     * @param authorNames the authorNames to set
     */
    public void setAuthorNames(String authorNames) {
        if (this.authorNames == null) {
            this.authorNames = authorNames;
        }
        else {
            this.authorNames = this.authorNames + "," + authorNames;
        }
    }

    /**
     * @return the journalName
     */
    public String getJournalName() {
        return journalName;
    }

    /**
     * @param journalName the journalName to set
     */
    public void setJournalName(String journalName) {
        if(journalName == null){
            this.journalName = " ";
        }
        else {
            this.journalName = journalName;
        }
    }

    /**
     * @return the conferenceName
     */
    public String getConferenceName() {
        return conferenceName;
    }

    /**
     * @param conferenceName the conferenceName to set
     */
    public void setConferenceName(String conferenceName) {
        if(conferenceName == null){
            this.conferenceName = " ";
        }
        else {
            this.conferenceName = conferenceName;
        }
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        if (this.keywords == null) {
            this.keywords = keywords;
        }
        else {
            this.keywords = this.keywords + "," + keywords;
        }
    }

    /**
     * @return the idPaperRefs
     */
    public String getIdPaperRefs() {
        return idPaperRefs;
    }

    /**
     * @param idPaperRefs the idPaperRefs to set
     */
    public void setIdPaperRefs(String idPaperRefs) {
        if (this.idPaperRefs == null) {
            this.idPaperRefs = idPaperRefs;
        }
        else {
            this.idPaperRefs = this.idPaperRefs + "," + idPaperRefs;
        }
    }

}
