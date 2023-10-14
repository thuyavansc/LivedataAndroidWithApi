package au.com.softclient.livedata1.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.repository.UserRepository;


//package au.com.softclient.livedata1.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.repository.UserRepository;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private LiveData<User> userData;

    public UserViewModel() {
        userRepository = new UserRepository();
        userData = userRepository.getUserData();
    }

    public LiveData<User> getUserData() {
        return userData;
    }

    public void fetchUser() {
        userRepository.fetchUser();
    }
}


/*
public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private LiveData<User> userData;

    public UserViewModel() {
        //--------------------------------------------
        userRepository = new UserRepository();
        userData = userRepository.getUserData();
    }

    public LiveData<User> getUserData() {
        return userData;
    }

    public void fetchUser() {
        userRepository.fetchUser();
    }
}
    /*
    private MutableLiveData<User> userData = new MutableLiveData<>();

    public LiveData<User> getUserData() {
        return userData;
    }

    public void fetchUser() {
        // In a real app, fetch user data here, but for this example, we'll simulate it
        User user = new User("John Doe", "johndoe@example.com");
        userData.setValue(user);
    }


*/
