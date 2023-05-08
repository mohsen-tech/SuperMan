package superman.me.superman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amin2 on 7/25/2017.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "shopsInfo";

    private static final String TABLE_SHOPS = "shops";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String KEY_PHONE = "phone";

    private static final String KEY_EMAIL = "email";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SHOPS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + "TEXT," +
                KEY_PHONE + "TEXT," + KEY_EMAIL + "TEXT," + ") ";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPS);

        onCreate(db);
    }


    public void addShop(Shooper shop) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shop.getNamefamily());
        values.put(KEY_PHONE, shop.getPhone());
        values.put(KEY_EMAIL, shop.getEmail());


        db.insert(TABLE_SHOPS, null, values);
        db.close();

    }


    public Shooper getShop(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SHOPS, new String[]{KEY_ID,
                        KEY_NAME, KEY_PHONE, KEY_EMAIL}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)

            cursor.moveToFirst();


        Shooper contact = new Shooper(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), (Integer.parseInt(cursor.getString(2))), cursor.getString(2));
        return contact;

    }

    public List<Shooper> getAllShops() {
        List<Shooper> shopList = new ArrayList<Shooper>();

        String selectQuery = "SELECT * FROM " + TABLE_SHOPS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                Shooper shop = new Shooper();
                shop.setId(Integer.parseInt(cursor.getString(0)));
                shop.setNamefamily(cursor.getString(1));
                shop.setPhone(Integer.parseInt(cursor.getString(2)));
                shop.setEmail(cursor.getString(3));


                shopList.add(shop);
            } while (cursor.moveToNext());
        }


        return shopList;
    }


    public int getShopsCount() {
        String countQuery = "SELECT * FROM " + TABLE_SHOPS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();


        return cursor.getCount();
    }


    public int updateShop(Shooper shop) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shop.getNamefamily());
        values.put(KEY_PHONE, shop.getPhone());
        values.put(KEY_EMAIL, shop.getEmail());


        return db.update(TABLE_SHOPS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(shop.getId())});
    }


    public void deleteShop(Shooper shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOPS, KEY_ID + " = ?",
                new String[]{String.valueOf(shop.getId())});
        db.close();
    }
}

