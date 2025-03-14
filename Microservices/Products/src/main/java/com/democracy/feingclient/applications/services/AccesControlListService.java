package com.democracy.feingclient.applications.services;

import com.democracy.feingclient.domain.enums.RolesEnum;
import com.democracy.feingclient.domain.models.Product;

//import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccesControlListService<T> {
	
	@Autowired
	private MutableAclService mutableAclService;

	private static final String DOMAIN = "co.com.delibolis.products.domain.models.";
	public int insert(T object) {
		Integer id = Math.abs(object.hashCode());
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("USER: "+user.getName()+", AUTHORITIES: "+user.getAuthorities());

		ObjectIdentity objectIdentity  = null;
		MutableAcl mutableAcl = null;
		String getDomain = object.getClass().getName();
		System.out.println("CLASE: "+getDomain);
		switch (getDomain) {
			case DOMAIN+"Product":
				System.out.println("ENTRO1");
				System.out.println("PRODUCT: "+((Product)object).getProductId());
				objectIdentity = new ObjectIdentityImpl(Product.class, ((Product)object).getProductId());
				System.out.println("LLEGO2");
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.MARKETING.getDescripcion()), true);
				mutableAcl.insertAce(4, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.SALES.getDescripcion()), true);
				break;

			/*case DOMAIN+"Direccion":
				objectIdentity = new ObjectIdentityImpl(Direccion.class, ((Direccion)object).getDireccionId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
				break;
			case DOMAIN+"Calle":
				objectIdentity = new ObjectIdentityImpl(Calle.class, ((Calle)object).getCalleId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
				break;
			case DOMAIN+"Departamento":
				objectIdentity = new ObjectIdentityImpl(Departamento.class, ((Departamento)object).getDepartamentoId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
				break;
			case DOMAIN+"ListaPrecios":
				objectIdentity = new ObjectIdentityImpl(ListaPrecios.class, ((ListaPrecios)object).getListaPrecioId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.SALES.getDescripcion()), true);
				break;
			case DOMAIN+"Impuesto":
				objectIdentity = new ObjectIdentityImpl(Impuesto.class, ((Impuesto)object).getImpuestoId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.COUNTER.getDescripcion()), true);
				break;
			case DOMAIN+"Cuenta":
				objectIdentity = new ObjectIdentityImpl(Cuenta.class, ((Cuenta)object).getCuentaId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.COUNTER.getDescripcion()), true);
				break;
			case DOMAIN+"GrupoCuenta":
				objectIdentity = new ObjectIdentityImpl(GrupoCuenta.class, ((GrupoCuenta)object).getGrupoCuentaId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.COUNTER.getDescripcion()), true);
				break;

			case DOMAIN+"TipoProducto":
				objectIdentity = new ObjectIdentityImpl(TipoProducto.class, ((TipoProducto)object).getTipProdId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.MARKETING.getDescripcion()), true);
				mutableAcl.insertAce(4, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.SALES.getDescripcion()), true);
				break;
			case DOMAIN+"Barrio":
				objectIdentity = new ObjectIdentityImpl(Barrio.class, ((Barrio)object).getBarrioId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.CONFIG.getDescripcion()), true);
				break;
			case DOMAIN+"Persona":
				objectIdentity = new ObjectIdentityImpl(Persona.class, ((Persona)object).getPersonaId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.RRHH.getDescripcion()), true);
				break;
			case DOMAIN+"User":
				objectIdentity = new ObjectIdentityImpl(co.com.mundocostenio.domain.model.User.class, ((co.com.mundocostenio.domain.model.User)object).getUserId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.RRHH.getDescripcion()), true);
				break;
			case DOMAIN+"Rol":
				objectIdentity = new ObjectIdentityImpl(Rol.class, ((Rol)object).getRolId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.RRHH.getDescripcion()), true);
				break;
			case DOMAIN+"PrecioProducto":
				objectIdentity = new ObjectIdentityImpl(PrecioProducto.class, ((PrecioProducto)object).getPrecioProdId());
				mutableAcl  = mutableAclService.createAcl(objectIdentity);
				mutableAcl.insertAce(0, BasePermission.WRITE,  new PrincipalSid(user.getName()), true);
				mutableAcl.insertAce(1, BasePermission.DELETE, new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(2, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.ADMIN.getDescripcion()), true);
				mutableAcl.insertAce(3, BasePermission.READ,   new GrantedAuthoritySid(RolesEnum.SALES.getDescripcion()), true);
				break;

			 */
			default:
				System.out.println("NO LLEGO A NINGUN LADO");
				break;
		}
		mutableAclService.updateAcl(mutableAcl);
		return id;
	}

	public void delete(T object) {
		ObjectIdentity oid = null;
		String getClase = object.getClass().getName();
		
		switch(getClase) {
			case DOMAIN+"Producto":
				oid = new ObjectIdentityImpl(Product.class, ((Product) object).getProductId());
				break;
				/*
			case DOMAIN+"ListaPrecios":
				oid = new ObjectIdentityImpl(ListaPrecios.class, ((ListaPrecios) object).getListaPrecioId());
				break;
			case DOMAIN+"Impuesto":
				oid = new ObjectIdentityImpl(Impuesto.class, ((Impuesto) object).getImpuestoId());
				break;
			case DOMAIN+"Cuenta":
				oid = new ObjectIdentityImpl(Cuenta.class, ((Cuenta) object).getCuentaId());
				break;
			case DOMAIN+"GrupoCuenta":
				oid = new ObjectIdentityImpl(GrupoCuenta.class, ((GrupoCuenta) object).getGrupoCuentaId());
				break;

			case DOMAIN+"TipoProducto":
				oid = new ObjectIdentityImpl(TipoProducto.class, ((TipoProducto) object).getTipProdId());
				break;
			case DOMAIN+"Barrio":
				oid = new ObjectIdentityImpl(Barrio.class, ((Barrio) object).getBarrioId());
				break;
			case DOMAIN+"Calle":
				oid = new ObjectIdentityImpl(Calle.class, ((Calle) object).getCalleId());
				break;
			case DOMAIN+"Persona":
				oid = new ObjectIdentityImpl(Persona.class, ((Persona) object).getPersonaId());
				break;
			case DOMAIN+"User":
				oid = new ObjectIdentityImpl(co.com.mundocostenio.domain.model.User.class, ((co.com.mundocostenio.domain.model.User) object).getUserId());
				break;
			case DOMAIN+"Rol":
				oid = new ObjectIdentityImpl(Rol.class, ((Rol) object).getRolId());
				break;
			case DOMAIN+"Departamento":
				oid = new ObjectIdentityImpl(Departamento.class, ((Departamento) object).getDepartamentoId());
				break;
			case DOMAIN+"PrecioProducto":
				oid = new ObjectIdentityImpl(PrecioProducto.class, ((PrecioProducto) object).getPrecioProdId());
				break;
				*/
			default:
				break;
		}
		mutableAclService.deleteAcl(oid, true);
	}
	
	public void setMutableAclService(MutableAclService mutableAclService) {
		this.mutableAclService = mutableAclService;
	}
}
