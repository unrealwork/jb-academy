package animals.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeNodeModel {
    private String data;
    private TreeNodeModel yes;
    private TreeNodeModel no;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNodeModel getYes() {
        return yes;
    }

    public void setYes(TreeNodeModel yes) {
        this.yes = yes;
    }

    public TreeNodeModel getNo() {
        return no;
    }

    public void setNo(TreeNodeModel no) {
        this.no = no;
    }

    @JsonIgnore
    public boolean isLeaf() {
        return no == null && yes == null;
    }
}
