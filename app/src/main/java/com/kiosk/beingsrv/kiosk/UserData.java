package com.kiosk.beingsrv.kiosk;

/**
 * Created by BeingSrv on 01/10/15.
 */
public class UserData {

    //private variables
    private String _fname;
    private String _lname;
    private String _email;
    private String _updatecheck;

    public String get_fname() {
        return _fname;
    }

    public void set_fname(String _fname) {
        this._fname = _fname;
    }

    public String get_lname() {
        return _lname;
    }

    public void set_lname(String _lname) {
        this._lname = _lname;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_updatecheck() {
        return _updatecheck;
    }

    public void set_updatecheck(String _updatecheck) {
        this._updatecheck = _updatecheck;
    }
}
