package bsl.co.ke.kephis;

import android.app.Application;
import android.graphics.Typeface;

import androidx.lifecycle.MutableLiveData;

import com.facebook.stetho.Stetho;

import org.idempiere.webservice.client.base.LoginRequest;

import bsl.co.ke.kephis.Pojo.ADUser;
import bsl.co.ke.kephis.Pojo.ConsignmentIspectionDetails;
import bsl.co.ke.kephis.Pojo.FacilityInspectionDetails;
import bsl.co.ke.kephis.Pojo.FarmInspectionDetails;
import bsl.co.ke.kephis.Pojo.ProducerInspectionDetails;
import bsl.co.ke.kephis.Pojo.User;
import bsl.co.ke.kephis.settings.Settings;
import bsl.co.ke.kephis.util.TypeFactory;

public class KEPHIS extends Application {
    private static KEPHIS mInstance;
    public Settings settings;
    private TypeFactory mFontFactory;

    public static synchronized KEPHIS getApp() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        settings = new Settings(getApplicationContext());

        Stetho.initializeWithDefaults(this);

        mInstance = this;
    }

    public Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new TypeFactory(this);

        switch (type) {
            case Constants.REGULAR:
                return mFontFactory.getRegular();

            case Constants.BOLD:
                return mFontFactory.getBold();

            default:
                return mFontFactory.getRegular();
        }
    }

    public interface Constants {
        int REGULAR = 1,
                BOLD = 2;
    }

    private User user;

    private User savedUser;

    private ADUser adUser;

    protected LoginRequest loginRequest;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getSavedUser() {
        return savedUser;
    }

    public void setSavedUser(User savedUser) {
        this.savedUser = savedUser;
    }

    public ADUser getAdUser() {
        return adUser;
    }

    public void setAdUser(ADUser adUser) {
        this.adUser = adUser;
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    private MutableLiveData<ProducerInspectionDetails> producerInspectionDetails;
    private MutableLiveData<FarmInspectionDetails> farmInspectionDetails;
    private MutableLiveData<FacilityInspectionDetails> facilityInspectionDetails;
    private MutableLiveData<ConsignmentIspectionDetails> consignmentIspectionDetails;


    public MutableLiveData<ProducerInspectionDetails> getProducerInspectionDetails() {
        if (producerInspectionDetails == null) {
            producerInspectionDetails = new MutableLiveData<ProducerInspectionDetails>();
        }
        return producerInspectionDetails;
    }
    public MutableLiveData<FarmInspectionDetails> getFarmInspectionDetails() {
        if (farmInspectionDetails == null) {
            farmInspectionDetails = new MutableLiveData<FarmInspectionDetails>();
        }
        return farmInspectionDetails;
    }

    public MutableLiveData<FacilityInspectionDetails> getFacilityInspectionDetails() {
        if (facilityInspectionDetails == null) {
            facilityInspectionDetails = new MutableLiveData<FacilityInspectionDetails>();
        }
        return facilityInspectionDetails;
    }

    public MutableLiveData<ConsignmentIspectionDetails> getConsignmentIspectionDetails() {
        if (consignmentIspectionDetails == null) {
            consignmentIspectionDetails = new MutableLiveData<ConsignmentIspectionDetails>();
        }
        return consignmentIspectionDetails;
    }
}
