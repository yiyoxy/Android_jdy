package com.app.jdy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jdy.R;
import com.umeng.analytics.MobclickAgent;

/**
 * 
 * description :图片轮播详情Activity
 * 
 * @version 1.0
 * @author zhonghuixiong
 * @createtime : 2015-3-19 下午4:32:47
 * 
 *             修改历史: 修改人 修改时间 修改内容 --------------- -------------------
 *             ----------------------------------- zhonghuixiong 2015-3-19
 *             下午4:32:47
 * 
 */
public class PictureActivity extends Activity {
	private WebView webView;
	// 返回按钮
	private ImageView back_img;
	// title_bar标题
	private TextView title_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture);
		// 加载webview
		back_img = (ImageView) findViewById(R.id.back_img);
		back_img.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		webView = (WebView) findViewById(R.id.picture_describe);
		WebSettings settings = webView.getSettings();
		settings.setSupportZoom(true);
		settings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
		webView.setBackgroundColor(0);
		// 加载URL
		webView.loadUrl(getIntent().getExtras().getString("url"));
		// 设置标题
		title_tv = (TextView) findViewById(R.id.title_tv);
		title_tv.setText(getIntent().getExtras().getString("title"));
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onPageStart("SplashScreen"); 
		MobclickAgent.onResume(this); 
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPageEnd("SplashScreen"); 
		MobclickAgent.onPause(this);
	}
}
