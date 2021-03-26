package com.makhabatusen.dependencyinjection.ui.favorites;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.dependencyinjection.App;
import com.makhabatusen.dependencyinjection.R;
import com.makhabatusen.dependencyinjection.data.models.Film;
import com.makhabatusen.dependencyinjection.databinding.ItemFavoriteFilmBinding;
import com.makhabatusen.dependencyinjection.ui.details.FilmDetailsListener;
import com.makhabatusen.dependencyinjection.ui.home.FilmTitles;

import java.util.ArrayList;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesHolder> {
    private final List<Film> favFilms = new ArrayList<>();
    private final FilmDetailsListener listener;

    public FavoritesAdapter(FilmDetailsListener listener) {
        this.listener = listener;
    }

    public void addFavFilmList(List<Film> list) {
        favFilms.clear();
        favFilms.addAll(list);
        notifyDataSetChanged();
    }

    public void addFilm(Film film) {
        favFilms.add(film);
        notifyItemInserted(favFilms.indexOf(film));
    }

    public void deleteFilm(Film film) {
        favFilms.remove(film);
        notifyItemRemoved(favFilms.indexOf(film));
    }




    @NonNull
    @Override
    public FavoritesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFavoriteFilmBinding ui = ItemFavoriteFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoritesHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesHolder holder, int position) {
        holder.onBind(favFilms.get(position));
    }

    @Override
    public int getItemCount() {
        return favFilms.size();
    }

    public class FavoritesHolder extends RecyclerView.ViewHolder {
        private final ItemFavoriteFilmBinding ui;

        public FavoritesHolder(@NonNull ItemFavoriteFilmBinding ui) {
            super(ui.getRoot());
            this.ui = ui;
        }


        public void onBind(Film film) {
            setPosters(film);
            removeFromFav(film);
            showDetails(film);


        }

        private void showDetails(Film film) {
            ui.ivFavFilm.setOnClickListener(v -> {
                listener.showDetails(film.getId());
            });


        }

        private void removeFromFav(Film film) {
            ui.btnRemoveFromFav.setOnClickListener(v -> {
                film.setFavorite(false);
                App.filmRepository.deleteFromFav(film);
                favFilms.remove(film);
                notifyItemRemoved(getAdapterPosition());
            });
        }


        private void setPosters(Film film) {
            switch (film.getTitle()) {
                case FilmTitles.CASTLE_IN_THE_SKY:
                    ui.ivFavFilm.setImageResource(R.drawable.castle_in_the_sky);
                    break;
                case FilmTitles.GRAVE_OF_THE_FIREFLIES:
                    ui.ivFavFilm.setImageResource(R.drawable.grave_of_the_fireflies);
                    break;
                case FilmTitles.MY_NEIGHBOR_TOTORO:
                    ui.ivFavFilm.setImageResource(R.drawable.my_neighbor_totoro);
                    break;
                case FilmTitles.KIKIS_DELIVERY_SERVICE:
                    ui.ivFavFilm.setImageResource(R.drawable.kikis_delivery_service);
                    break;
                case FilmTitles.ONLY_YESTERDAY:
                    ui.ivFavFilm.setImageResource(R.drawable.only_yesterday);
                    break;
                case FilmTitles.PORCO_ROSSO:
                    ui.ivFavFilm.setImageResource(R.drawable.porco_rosso);
                    break;
                case FilmTitles.POM_POKO:
                    ui.ivFavFilm.setImageResource(R.drawable.pom_poko);
                    break;
                case FilmTitles.WHISPER_OF_THE_HEART:
                    ui.ivFavFilm.setImageResource(R.drawable.whisper_of_the_heart);
                    break;
                case FilmTitles.PRINCESS_MONONOKE:
                    ui.ivFavFilm.setImageResource(R.drawable.princess_mononoke);
                    break;
                case FilmTitles.MY_NEIGHBORS_THE_YAMADAS:
                    ui.ivFavFilm.setImageResource(R.drawable.my_neighbors_the_yamadas);
                    break;
                case FilmTitles.SPIRITED_AWAY:
                    ui.ivFavFilm.setImageResource(R.drawable.spirited_away);
                    break;
                case FilmTitles.THE_CAT_RETURNS:
                    ui.ivFavFilm.setImageResource(R.drawable.the_cat_returns);
                    break;
                case FilmTitles.HOWLS_MOVING_CASTLE:
                    ui.ivFavFilm.setImageResource(R.drawable.howls_moving_castle);
                    break;
                case FilmTitles.TALES_FROM_EARTSEA:
                    ui.ivFavFilm.setImageResource(R.drawable.tales_from_earthsea);
                    break;
                case FilmTitles.PONYO:
                    ui.ivFavFilm.setImageResource(R.drawable.ponyo);
                    break;
                case FilmTitles.ANRIETTY:
                    ui.ivFavFilm.setImageResource(R.drawable.arrietty);
                    break;
                case FilmTitles.FROM_UP_ON_POPPY_HILL:
                    ui.ivFavFilm.setImageResource(R.drawable.from_up_on_poppy_hill);
                    break;
                case FilmTitles.THE_WIND_RISES:
                    ui.ivFavFilm.setImageResource(R.drawable.the_wind_rises);
                    break;
                case FilmTitles.THE_TALE_OF_PRINCESS_KAGUYA:
                    ui.ivFavFilm.setImageResource(R.drawable.the_tale_of_princess_kaguya);
                    break;
                case FilmTitles.WHEN_MARNIE_WAS_THERE:
                    ui.ivFavFilm.setImageResource(R.drawable.when_marnie_was_there);
                    break;
                case FilmTitles.THE_RED_TURTLE:
                    ui.ivFavFilm.setImageResource(R.drawable.the_red_turtle);
                    break;
            }
        }
    }
}
