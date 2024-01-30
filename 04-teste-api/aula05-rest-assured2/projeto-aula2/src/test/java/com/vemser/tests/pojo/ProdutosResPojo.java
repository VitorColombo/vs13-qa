package com.vemser.tests.pojo;

public class ProdutosResPojo extends ProdutosReqPojo{
    private String _id;
    private String message;

    public ProdutosResPojo() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
            return "ProdutosResPojo{" +
                    "id='" + this._id + '\'' +
                    ", message='" + this.message + '\'' +
                    '}';
    }
}
