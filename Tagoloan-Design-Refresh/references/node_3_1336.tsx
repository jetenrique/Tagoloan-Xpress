const assetPathPrefix = "https://www.figma.com/api/mcp/asset/d46dad6d-7e62-44c8-b5d3-e60638d32377";
const imgPhoto = `${assetPathPrefix}/c38b0.png`;
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconCheck = `${assetPathPrefix}/cd8ea.svg`;
const imgIconStar = `${assetPathPrefix}/9aab1.svg`;
const imgIconPhone = `${assetPathPrefix}/e448f.svg`;

export default function RiderAccepted() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:1336" data-name="rider accepted">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="127:66" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="127:67" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="127:68" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="127:69">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="127:70" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="127:71" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="127:73" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="127:75" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[16px] items-start min-h-px overflow-clip px-[16px] py-[24px] relative w-full" data-node-id="127:77" data-name="Body">
          <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="127:78" data-name="Flexible space" />
          <div className="content-stretch flex flex-col gap-[8px] items-center overflow-clip relative shrink-0 w-full" data-node-id="127:79" data-name="Container">
            <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[36px] shrink-0 size-[72px]" data-node-id="127:80" data-name="Container">
              <div className="relative shrink-0 size-[34px]" data-node-id="127:81" data-name="icon/check">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
              </div>
            </div>
            <div className="h-[8px] relative shrink-0 w-px" data-node-id="127:83" data-name="Container" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[24px] text-center w-[min-content]" data-node-id="127:84">
              Rider found!
            </p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] text-center w-[min-content]" data-node-id="127:85">
              Juan is heading to Minute Burger to buy your order.
            </p>
          </div>
          <div className="h-[8px] relative shrink-0 w-px" data-node-id="127:86" data-name="Container" />
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[14px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="127:87" data-name="Rider">
            <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="127:88" data-name="Rider">
              <div className="relative shrink-0 size-[48px]" data-node-id="127:89" data-name="Photo">
                <img alt="" className="absolute block inset-0 max-w-none size-full" height="48" src={imgPhoto} width="48" />
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="127:90" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="127:91">
                  Juan Dela Cruz
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="127:92">
                  Honda Click 125i · ABC 1234
                </p>
              </div>
              <div className="bg-[#fff7e0] content-stretch flex gap-[4px] items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="127:93" data-name="Chip">
                <div className="relative shrink-0 size-[12px]" data-node-id="127:94" data-name="icon/star">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconStar} />
                </div>
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[12px] whitespace-nowrap" data-node-id="127:96">
                  4.9
                </p>
              </div>
            </div>
            <div className="bg-[#ece8df] h-px relative shrink-0 w-full" data-node-id="127:97" data-name="Divider" />
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="127:98" data-name="Row – Request">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="127:99">
                Request
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="127:100">
                #TGX-8921
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="127:101" data-name="Row – Pickup">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="127:102">
                Pickup
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="127:103">
                Minute Burger, Poblacion
              </p>
            </div>
          </div>
          <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="127:104" data-name="Flexible space" />
          <a className="bg-[#febc20] content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="127:105" data-name="Button – Track delivery">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="127:106">
              Track delivery
            </p>
          </a>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[8px] items-center justify-center overflow-clip py-[13px] relative rounded-[14px] shrink-0 w-full" data-node-id="127:108" data-name="Button – Call rider">
            <div className="relative shrink-0 size-[16px]" data-node-id="127:109" data-name="icon/phone">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPhone} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] whitespace-nowrap" data-node-id="127:111">
              Call rider
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
