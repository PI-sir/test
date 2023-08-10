package homework;

public class Note {
    private String id;                  //记录的id
    private String notepadContent;   //记录的内容
    private String notepadTime;       //保存记录的时间
    //右击-【Generate】-【Getter and Setter】，产生下面代码
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNotepadContent() {
        return notepadContent;
    }
    public void setNotepadContent(String notepadContent) {
        this.notepadContent = notepadContent;
    }
    public String getNotepadTime() {
        return notepadTime;
    }
    public void setNotepadTime(String notepadTime) {
        this.notepadTime = notepadTime;
    }
}
