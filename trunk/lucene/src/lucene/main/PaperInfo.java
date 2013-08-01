/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lucene.main;

/**
 *
 * @author DucHuynh
 */
public class PaperInfo {
    public String idPaper;
    public String title;
    public String abstractContent;
    public String authors;
    public String journalName;
    public String conferenceName;
    public String listAuthor;
    public int year;   
    
    public PaperInfo(){
        
    }

    public void setListAuthor(String listAuthor) {
        this.listAuthor = listAuthor;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public String getAuthors() {
        return authors;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public String getIdPaper() {
        return idPaper;
    }

    public String getJournalName() {
        return journalName;
    }

    public String getListAuthor() {
        return listAuthor;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
    
    public void setAbstractContent(String abstractContent) {
        if(abstractContent == null) {
            this.abstractContent = " ";
        }else this.abstractContent = abstractContent;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setConferenceName(String conferenceName) {
        if(conferenceName == null){
            this.conferenceName = " ";
        }else this.conferenceName = conferenceName;
    }

    public void setIdPaper(String idPaper) {
        this.idPaper = idPaper;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {       
        this.year = year;        
    }    
}
