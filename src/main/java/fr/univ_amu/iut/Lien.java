package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;

public class Lien
{
    private Module module;
    private Etudiant etudiant;
    private Notation note;

    public Lien(Module mod, Etudiant etu)
    {
        module=mod;
        etudiant=etu;
    }

    public Module getModule()
    {
        return module;
    }
    public Etudiant getEtudiant()
    {
        return etudiant;
    }
    public Notation getNotation()
    {
        return note;
    }
    public void setNotation(Notation m_Note)
    {
        note = m_Note;
    }

}

