package kk.play.fragments;

import kk.play.stockmanagement.LruBitmapCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class ImageVolleyController extends Application {
	public static final String TAG = ImageVolleyController.class.getSimpleName();
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private static ImageVolleyController mInstance;

	public void onCreate() {
		super.onCreate();
		mInstance = this;
	}

	public static synchronized ImageVolleyController getInstance() {
		return mInstance;

	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null)
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		return mRequestQueue;
	}

	public ImageLoader getImageLoader() {
		getRequestQueue();
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(this.mRequestQueue,
					new LruBitmapCache());
		}
		return mImageLoader;
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null)
			mRequestQueue.cancelAll(tag);
	}
}
