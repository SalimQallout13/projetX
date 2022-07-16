package com.tdev.projectx.service;

import com.tdev.projectx.model.Club;

import java.util.List;

public interface ClubService {
    List<Club> getClubs();

    Club getClubByID(Long clubID);

    Club addClub(Club club);

    Club updateClub(Club club);

    void deleteClub(Long clubID);

    List<Club> getClubByName(String name);
}
