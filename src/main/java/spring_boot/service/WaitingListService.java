package spring_boot.service;

import spring_boot.entity.WaitingList;

import java.util.List;
import java.util.Optional;


public interface WaitingListService {

    void addEntry(WaitingList waitingList);

    void updateEntry(WaitingList waitingList);

    void removeEntryById(long id);

    Optional<WaitingList> getEntryById(long id);

    List<WaitingList> getAllEntry();


}
