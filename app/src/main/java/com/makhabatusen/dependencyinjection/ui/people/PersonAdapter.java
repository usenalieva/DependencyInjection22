package com.makhabatusen.dependencyinjection.ui.people;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.dependencyinjection.data.models.Person;
import com.makhabatusen.dependencyinjection.databinding.ItemPersonBinding;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {

    private final List<Person> personList;

    public PersonAdapter() {
        personList = new ArrayList<>();
    }

    public void addPeople(List<Person> personList) {
        this.personList.addAll(personList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemPersonBinding ui = ItemPersonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PersonHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
    holder.onBind(personList.get(position));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class PersonHolder extends RecyclerView.ViewHolder{
        private final ItemPersonBinding ui;

        public PersonHolder(@NonNull ItemPersonBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
        }

        public void onBind(Person person) {
            ui.tvPerson.setText(String.format("%s\n%s", person.getName(), person.getAge()));

        }
    }
}
