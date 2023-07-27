package com.example.dog_app.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dog_app.CommentsActivity;
import com.example.dog_app.EditProfileActivity;
import com.example.dog_app.FollowersActivity;
import com.example.dog_app.Fragments.PostDetailFragment;
import com.example.dog_app.Fragments.ProfileFragment;
import com.example.dog_app.MainActivity;
import com.example.dog_app.Model.Mypet;
import com.example.dog_app.Model.Post;
import com.example.dog_app.Model.User;
import com.example.dog_app.MypetActivity;
import com.example.dog_app.NewpetActivity;
import com.example.dog_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MypetAdapter extends RecyclerView.Adapter<MypetAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Mypet> mMypet;
    private FirebaseUser firebaseUser;

    public MypetAdapter(Context context, List<Mypet> mypets){
        mContext = context;
        mMypet = mypets;
    }


    @NonNull
    @Override
    public MypetAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.mypet_item, parent, false);
        return new MypetAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MypetAdapter.ImageViewHolder holder, final int position) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        final Mypet mypet = mMypet.get(position);
        Glide.with(mContext).load(mypet.getPostimage())
                .apply(new RequestOptions().placeholder(R.drawable.ic_warry))
                .into(holder.post_image);



        publisherInfo(holder.image_profile, holder.username, holder.publisher, mypet.getPublisher());

        getCommetns(mypet.getPostid(), holder.med, holder.pet_name, holder.allerg , holder.chip, holder.birthday);





//        holder.image_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", MODE_PRIVATE).edit();
//                editor.putString("profileid", mypet.getPublisher());
//                editor.apply();
//
//                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new ProfileFragment()).commit();
//            }
//        });


        holder.username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("profileid", mypet.getPublisher());
                editor.apply();

                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
            }
        });

        holder.publisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("profileid", mypet.getPublisher());
                editor.apply();

                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
            }
        });
//


//        holder.post_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", MODE_PRIVATE).edit();
//                editor.putString("postid", mypet.getPostid());
//                editor.apply();
//
//                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new PostDetailFragment()).commit();
//            }
//        });



        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(mContext, view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.edit:
                                editPost(mypet.getPostid());
                                return true;

                            case R.id.birthday:
                                editBirthday(mypet.getPostid());
                                return true;

                            case R.id.allerg:
                                editAllerg(mypet.getPostid());
                                return true;
                            case R.id.chip:
                                editChip(mypet.getPostid());
                                return true;
                            case R.id.med:
                                editMed(mypet.getPostid());
                                return true;
                            case R.id.delete:
                                final String id = mypet.getPostid();
                                FirebaseDatabase.getInstance().getReference("Mypet")
                                        .child(mypet.getPostid()).removeValue()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    deleteNotifications(id, firebaseUser.getUid());
                                                }


                                            }
                                        });
                                return true;
                            case R.id.report:
                                Toast.makeText(mContext, "回報成功!", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.inflate(R.menu.mypet_menu);
                if (!mypet.getPublisher().equals(firebaseUser.getUid())){
                    popupMenu.getMenu().findItem(R.id.edit).setVisible(false);
                    popupMenu.getMenu().findItem(R.id.delete).setVisible(false);
                }
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMypet.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageView image_profile, post_image, like, comment, save, more;
        public TextView username, likes, publisher, birthday, med, pet_name, chip, allerg;

        public ImageViewHolder(View itemView) {
            super(itemView);

            image_profile = itemView.findViewById(R.id.image_profile);
            username = itemView.findViewById(R.id.username);
            post_image = itemView.findViewById(R.id.post_image);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            save = itemView.findViewById(R.id.save);
            likes = itemView.findViewById(R.id.likes);
            more = itemView.findViewById(R.id.more);
            publisher = itemView.findViewById(R.id.publisher);
            birthday = itemView.findViewById(R.id.birthday);
            med = itemView.findViewById(R.id.med);
            pet_name = itemView.findViewById(R.id.pet_name);
            chip = itemView.findViewById(R.id.chip);
            allerg = itemView.findViewById(R.id.allerg);

        }
    }



    private void deleteNotifications(final String postid, String userid){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Mypet").child(userid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if (snapshot.child("postid").getValue().equals(postid)){
                        snapshot.getRef().removeValue()
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(mContext, "Deleted!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    private void getCommetns(String postId, final TextView med, final TextView pet_name, final TextView birthday, final TextView chip, final TextView allerg){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child("Mypet").child(postId);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Mypet mypet = dataSnapshot.getValue(Mypet.class);
                med.setText("使用藥物紀錄:"+mypet.getMed());
                pet_name.setText("寵物名:"+mypet.getName());
                birthday.setText("生日:"+mypet.getBirthday());
                chip.setText("是否植入晶片:"+mypet.getChip());
                allerg.setText("藥物過敏紀錄:"+mypet.getAllerg());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void publisherInfo(final ImageView image_profile, final TextView username, final TextView publisher, final String userid){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference()
                .child("Users").child(userid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                Glide.with(mContext).load(user.getImageurl()).into(image_profile);
                username.setText(user.getUsername());
                publisher.setText(user.getUsername());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    private void editPost(final String postid){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle("編輯寵物名");

        final EditText editText = new EditText(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(lp);
        alertDialog.setView(editText);



        getText(postid, editText);

        alertDialog.setPositiveButton("確定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("name", editText.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Mypet")
                                .child(postid).updateChildren(hashMap);
                    }
                });
        alertDialog.setNegativeButton("離開",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        alertDialog.show();
    }

    private void getText(String postid, final EditText editText){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Mypet")
                .child(postid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                editText.setText(dataSnapshot.getValue(Mypet.class).getName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void editBirthday(final String postid){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle("編輯寵物生日");

        final EditText editText = new EditText(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(lp);
        alertDialog.setView(editText);



        getBir(postid, editText);

        alertDialog.setPositiveButton("確定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("birthday", editText.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Mypet")
                                .child(postid).updateChildren(hashMap);
                    }
                });
        alertDialog.setNegativeButton("離開",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        alertDialog.show();
    }

    private void getBir(String postid, final EditText editText){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Mypet")
                .child(postid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                editText.setText(dataSnapshot.getValue(Mypet.class).getBirthday());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void editAllerg(final String postid){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle("編輯寵物過敏記錄");

        final EditText editText = new EditText(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(lp);
        alertDialog.setView(editText);



        getAll(postid, editText);

        alertDialog.setPositiveButton("確定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("allerg", editText.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Mypet")
                                .child(postid).updateChildren(hashMap);
                    }
                });
        alertDialog.setNegativeButton("離開",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        alertDialog.show();
    }

    private void getAll(String postid, final EditText editText){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Mypet")
                .child(postid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                editText.setText(dataSnapshot.getValue(Mypet.class).getAllerg());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void editChip(final String postid){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle("編輯寵物晶片記錄");

        final EditText editText = new EditText(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(lp);
        alertDialog.setView(editText);



        getChip(postid, editText);

        alertDialog.setPositiveButton("確定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("chip", editText.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Mypet")
                                .child(postid).updateChildren(hashMap);
                    }
                });
        alertDialog.setNegativeButton("離開",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        alertDialog.show();
    }

    private void getChip(String postid, final EditText editText){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Mypet")
                .child(postid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                editText.setText(dataSnapshot.getValue(Mypet.class).getChip());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void editMed(final String postid){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle("編輯寵物藥物記錄");

        final EditText editText = new EditText(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(lp);
        alertDialog.setView(editText);



        getMed(postid, editText);

        alertDialog.setPositiveButton("確定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("med", editText.getText().toString());
                        FirebaseDatabase.getInstance().getReference("Mypet")
                                .child(postid).updateChildren(hashMap);
                    }
                });
        alertDialog.setNegativeButton("離開",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        alertDialog.show();
    }

    private void getMed(String postid, final EditText editText){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Mypet")
                .child(postid);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                editText.setText(dataSnapshot.getValue(Mypet.class).getMed());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}