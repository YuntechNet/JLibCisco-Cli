package tw.edu.yuntech.yunnet.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.util.regex.Pattern;

public class LimitDocByRegex extends PlainDocument {

    private int maxLength = -1;
    private String regx = null;

    public LimitDocByRegex() {
        super();
    }

    public LimitDocByRegex(int maxLength) {
        super();
        this.maxLength = maxLength;
    }

    public LimitDocByRegex(int maxLength, String regx) {
        super();
        this.maxLength = maxLength;
        this.regx = regx;
    }

    public void insertString(int offset, String str, AttributeSet attrSet) throws BadLocationException {
        if (str == null)
            return;

        if (this.regx != null && str.length() == 1) {
            if(!Pattern.matches(this.regx, str))
                return;
        }
        char[] charVal = str.toCharArray();
        String strOldValue = getText(0, getLength());
        char[] tmp = strOldValue.toCharArray();
        if (this.maxLength != -1 && (tmp.length + charVal.length > this.maxLength))
            return;
        super.insertString(offset, str, attrSet);
    }
}