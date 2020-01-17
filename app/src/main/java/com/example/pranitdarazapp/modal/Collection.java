package com.example.pranitdarazapp.modal;

public class Collection {


    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String get_intro() {
        return _intro;
    }

    public void set_intro(String _intro) {
        this._intro = _intro;
    }

    private String _title;
    private String image;
    private String _intro;





//    @Override
//    public String toString()
//    {
//        return "tbl_collection [_colletionId = "+_colletionId+", _cTitle = "+_cTitle+"," +
//                " _cIntroduction = "+_cIntroduction+", _cImage = "+_cImage+", _cBackground = "+_cBackground+"]";
//    }

}