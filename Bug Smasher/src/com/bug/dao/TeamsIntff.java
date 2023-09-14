package com.bug.dao;

import java.util.List;

import com.bug.model.Teams;

public interface TeamsIntff {
    Teams getTeamById(int teamId);

    List<Teams> getAllTeams();

    void createTeam(Teams team);

    void updateTeam(Teams team);

    void deleteTeam(int teamId);
}
