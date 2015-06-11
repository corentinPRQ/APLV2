package ClientsServeurs;
//package Serveurs;
//
//import org.omg.CORBA.ORB;
//import org.omg.CosNaming.NamingContext;
//import org.omg.CosNaming.NamingContextPackage.CannotProceed;
//import org.omg.CosNaming.NamingContextPackage.InvalidName;
//import org.omg.CosNaming.NamingContextPackage.NotFound;
//import org.omg.PortableServer.POA;
//import org.omg.PortableServer.POAHelper;
//import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
//import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
//import org.omg.PortableServer.POAPackage.ServantNotActive;
//import org.omg.PortableServer.POAPackage.WrongPolicy;
//
//import Universite.IUniversite;
//import Universite.IUniversiteImpl;
//
//public class ServeurGestionEtudiant implements Runnable{
//	
//	private static IUniversite monUnivClt;
//	private org.omg.CORBA.ORB orb;
//	private NamingContext nameRoot;
//	private String nomObj;
//	
//	public ServeurGestionEtudiant(ORB orb, NamingContext nameRoot, String nomObj) {
//		super();
//		this.orb = orb;
//		this.nameRoot = nameRoot;
//		this.nomObj = nomObj;
//	}
//	
//	public void travailler (){
//		try {
//			// Gestion du POA
//			//****************
//			// Recuperation du POA
//			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
//
//			// Creation du servant
//			//*********************
//			IUniversiteImpl monUniv = new IUniversiteImpl();
//
//			// Activer le servant au sein du POA et recuperer son ID
//			byte[] monUnivId = rootPOA.activate_object(monUniv);
//
//			// Activer le POA manager
//			rootPOA.the_POAManager().activate();
//
//			// Construction du nom a enregistrer
//			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
//			nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");
//
//			// Enregistrement de l'objet CORBA dans le service de noms
//
//			nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(monUniv));
//
//			System.out.println("==> Nom '"+ nomObj + "' est enregistre dans le service de noms.");
//
//			String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monUniv));
//			System.out.println("L'objet possede la reference suivante :");
//			System.out.println(IORServant);
//
//
//			// Lancement de l'ORB et mise en attente de requete
//			//**************************************************
//			orb.run();
//
//
//		} catch (NotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (CannotProceed e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidName e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServantNotActive e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (WrongPolicy e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  catch (ServantAlreadyActive e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (org.omg.CORBA.ORBPackage.InvalidName e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AdapterInactive e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		travailler();
//	}
//
//	
//}
