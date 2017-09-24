package com.nebulaera.myandroidtestdemo;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 使用 res/xml下的资源
 */
public class RawXmlActivity extends AppCompatActivity {
    @BindView(R.id.txt_test_show_parse_xml)
    TextView showParseTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_xml);
        ButterKnife.bind(this);
        //将xml文件读取到内存中
        try {
            XmlResourceParser xml = getResources().getXml(R.xml.my_book);
            int eventType;
            StringBuilder stringBuilder = new StringBuilder();
            while ((eventType = xml.getEventType()) != XmlResourceParser.END_DOCUMENT) {
                //是开始标签
                if (eventType == XmlResourceParser.START_TAG) {
                    String tagName = xml.getName();
                    if ("book".equals(tagName)) {
                        String price = xml.getAttributeValue(null, "price");
                        stringBuilder.append("price=").append(price);
                        String attributeName = xml.getAttributeName(1);
                        String attributeValue = xml.getAttributeValue(1);
                        stringBuilder.append(attributeName).append("=").append(attributeValue);
                        stringBuilder.append("\n");
                    }
                }
                //驱动到下一个事件
                xml.next();
            }
            //展示解析内容
            showParseTxt.setText(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
