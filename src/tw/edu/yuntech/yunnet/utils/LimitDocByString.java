package tw.edu.yuntech.yunnet.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitDocByString extends PlainDocument {

    private int maxLength = -1;
    private String allowCharAsString = null;

    public LimitDocByString() {
        super();
    }

    public LimitDocByString(int maxLength) {
        super();
        this.maxLength = maxLength;
    }

    public LimitDocByString(int maxLength, String allowCharAsString) {
        super();
        this.maxLength = maxLength;
        this.allowCharAsString = allowCharAsString;
    }

    public void insertString(int offset, String str, AttributeSet attrSet) throws BadLocationException {
        if (str == null)
            return;

        if (this.allowCharAsString != null && str.length() == 1) {
            if (this.allowCharAsString.indexOf(str) == -1)
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