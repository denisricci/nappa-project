package br.com.nappa.indexes;

import br.com.nappa.model.EconomicIndex;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

public interface EconomicIndexHistory {

  public List<EconomicIndex> getIndexHistory(EconimicIndex index, LocalDate startDate, LocalDate endDate) throws RemoteException;

}