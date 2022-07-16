package com.tdev.projectx.service.Impl;

import com.tdev.projectx.model.Club;
import com.tdev.projectx.repo.ClubRepository;
import com.tdev.projectx.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club getClubByID(Long clubID) {
        Optional<Club> club = clubRepository.findById(clubID);
        if (club.isPresent()) {
            return club.get();
        }
        throw new RuntimeException("Club not found for this id: " + clubID);
    }

    @Override
    public Club addClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public Club updateClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long clubID) {
        clubRepository.deleteById(clubID);
    }

    @Override
    public List<Club> getClubByName(String name) {
        return clubRepository.findByNameContaining(name);
    }

}
